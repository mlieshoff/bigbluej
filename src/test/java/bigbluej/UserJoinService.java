package bigbluej;/*
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

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author Michael Lieshoff
 */
public class UserJoinService extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Api api = Api.builder()
                .url("http://test-install.blindsidenetworks.com/bigbluebutton/api")
                .sharedSecret("8cd8ef52e8e101574e400365b55e11a6")
                .build();

        String meetingID = req.getParameter("meetingID");
        JoinCommand joinCommand = JoinCommand.builder()
                .fullName("Al Bundy")
                .meetingID(meetingID)
                .password("passpass")
                .build();

        try {
            api.joinMeeting(res, joinCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
