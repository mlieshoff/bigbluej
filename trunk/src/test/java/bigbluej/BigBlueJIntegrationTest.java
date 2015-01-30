package bigbluej;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Michael Lieshoff
 */
public class BigBlueJIntegrationTest {

    private Api api;

    private Server server;

    private volatile boolean isRunning = false;

    @Before
    public void setUp() throws Exception {
        api = Api.builder()
                .url("http://test-install.blindsidenetworks.com/bigbluebutton/api")
                .sharedSecret("8cd8ef52e8e101574e400365b55e11a6")
                .build();
        server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/my-app", true, false);
        servletContextHandler.addServlet(UserJoinService.class, "/join");
        server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStarted(LifeCycle event) {
                isRunning = true;
                super.lifeCycleStarted(event);
            }
        });
        server.start();
        while(!isRunning) {
            Thread.sleep(100);
        }
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void shouldCreateMeeting() throws Exception {
        String meetingID = "myMeeting" + System.currentTimeMillis();
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID(meetingID)
                .attendeePW("passpass")
                .moderatorPW("superpass")
                .name("myMeeting")
                .welcome("<br>Welcome to <b>%%CONFNAME%%</b>!")
                .build();
        checkMeetingResponse(createCommand, api.createMeeting(createCommand));
    }

    private void checkMeetingResponse(CreateCommand createCommand, MeetingResponse meetingResponse) {
        assertEquals(ReturnCode.SUCCESS, meetingResponse.getReturnCode());
        assertEquals(createCommand.getMeetingID(), meetingResponse.getMeetingID());
        assertEquals(createCommand.getAttendeePW(), meetingResponse.getAttendeePW());
        assertEquals(createCommand.getModeratorPW(), meetingResponse.getModeratorPW());
    }

    @Test
    public void shouldCreateMeetingWithSlides() throws Exception {
        String meetingID = "myMeeting" + System.currentTimeMillis();
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID(meetingID)
                .attendeePW("passpass")
                .moderatorPW("superpass")
                .name("myMeeting")
                .welcome("<br>Welcome to <b>%%CONFNAME%%</b>!")
                .build();
        ModulesCommand modulesCommand = ModulesCommand.builder()
                .module(ModuleCommand.builder()
                        .name("presentation")
                        .document(DocumentCommand.builder()
                                .url("http://www.wave.org.au/jupgrade/images/sample.pdf")
                                .build())
/*                        .document(DocumentCommand.builder()
                                .name("testpdf.pdf")
                                .content(FileUtils.readFileToByteArray(new File("src/test/resources/testpdf.pdf")))
                                .build())
*/
                        .build())
                .build();
        checkMeetingResponse(createCommand, api.createMeeting(createCommand, modulesCommand));
    }

    @Test
    public void shouldJoinMeeting() throws Exception {
        String meetingID = "myMeeting" + System.currentTimeMillis();
        // create
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID(meetingID)
                .attendeePW("passpass")
                .moderatorPW("superpass")
                .name("myMeeting")
                .welcome("<br>Welcome to <b>%%CONFNAME%%</b>!")
                .build();
        MeetingResponse meetingResponse = api.createMeeting(createCommand);
        // join as moderator
        String result = new Crawler().post("http://localhost:8080/my-app/join?meetingID=" + meetingResponse.getMeetingID());
        System.out.println("result> " + result);
        // get meeting info
        GetMeetingInfoCommand getMeetingInfoCommand = GetMeetingInfoCommand.builder()
                .meetingID(meetingID)
                .password("superpass")
                .build();
        GetMeetingInfoResponse getMeetingInfoResponse = api.getMeetingInfo(getMeetingInfoCommand);
        checkGetMeetingInfoResponse(getMeetingInfoCommand, getMeetingInfoResponse);
        System.out.println("--> " + getMeetingInfoResponse);
    }

    @Test
    public void shouldIsMeetingRunning() throws Exception {
        String meetingID = "myMeeting" + System.currentTimeMillis();
        // create
        CreateCommand createCommand = CreateCommand.builder()
                .meetingID(meetingID)
                .attendeePW("passpass")
                .moderatorPW("superpass")
                .name("myMeeting")
                .welcome("<br>Welcome to <b>%%CONFNAME%%</b>!")
                .build();
        MeetingResponse meetingResponse = api.createMeeting(createCommand);
        // join as moderator
        String result = new Crawler().post("http://localhost:8080/my-app/join?meetingID=" + meetingResponse.getMeetingID());
        System.out.println("result> " + result);
        IsMeetingRunningCommand isMeetingRunningCommand = IsMeetingRunningCommand.builder()
                .meetingID(meetingResponse.getMeetingID())
                .build();
        IsMeetingRunningResponse isMeetingRunningResponse = api.isMeetingRunning(isMeetingRunningCommand);
        assertEquals(ReturnCode.SUCCESS, isMeetingRunningResponse.getReturnCode());
        assertTrue(isMeetingRunningResponse.isRunning());
    }

    private void checkGetMeetingInfoResponse(GetMeetingInfoCommand getMeetingInfoCommand, GetMeetingInfoResponse getMeetingInfoResponse) {
        assertEquals(ReturnCode.SUCCESS, getMeetingInfoResponse.getReturnCode());
    }

    @Test
    public void shouldGetMeetings() throws Exception {
        MeetingsResponse meetingsResponse = api.getMeetings();
        assertEquals(ReturnCode.SUCCESS, meetingsResponse.getReturnCode());
    }

}
