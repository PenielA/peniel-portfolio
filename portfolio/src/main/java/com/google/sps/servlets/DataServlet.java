// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    // private ArrayList<String> messages = new ArrayList<String>();
    Entity commentEntity = new Entity("Comment");

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // String text = request.getParameter("text-input");
        // comments.add(text);
        String text = request.getParameter("text-input");

        commentEntity.setProperty("text", text);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(commentEntity);

        response.sendRedirect("/index.html");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(commentEntity);
        response.setContentType("application/json");
        response.getWriter().println(json);
    }
    
//   private List<String> quotes;

//   @Override
//   public void init() {
//     // quotes = new ArrayList<>();
//     // quotes.add(
//     //     "A ship in port is safe, but that is not what ships are for. "
//     //         + "Sail out to sea and do new things. - Grace Hopper");
//     // quotes.add("They told me computers could only do arithmetic. - Grace Hopper");
//     // quotes.add("A ship in port is safe, but that's not what ships are built for. - Grace Hopper");
//     // quotes.add("It is much easier to apologise than it is to get permission. - Grace Hopper");
//     // quotes.add("If you can't give me poetry, can't you give me poetical science? - Ada Lovelace");
//     // quotes.add("I am in a charming state of confusion. - Ada Lovelace");
//     // quotes.add(
//     //     "The Analytical Engine weaves algebraic patterns, "
//     //         + "just as the Jacquard loom weaves flowers and leaves. - Ada Lovelace");
//     // quotes.add(
//     //     "Sometimes it is the people no one can imagine anything of "
//     //         + "who do the things no one can imagine. - Alan Turing");
//     // quotes.add("Those who can imagine anything, can create the impossible. - Alan Turing");
//   }

//   @Override
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//     ArrayList<String> greetings = new ArrayList<>();
//     // greetings.add("Welcome ");
//     // greetings.add("to");
//     // greetings.add("my Portfolio");

//     // String quote = quotes.get((int) (Math.random() * quotes.size()));

//     // response.setContentType("text/html;");
//     // response.getWriter().println(quote);

//     Gson gson = new Gson();
//     String json = gson.toJson(greetings);
//     response.setContentType("application/json");
//     response.getWriter().println(json);
//   }
}
