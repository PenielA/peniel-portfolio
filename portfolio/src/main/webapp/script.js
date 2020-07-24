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

/**
 * Adds a random greeting to the page.
 */
// function addRandomGreeting() {
//   const greetings =
//       ['I love math!', 'I am the oldest of 5!','I have a huge obsession with Percy Jackson', 
//       'I am Bilingual', 'I enjoy cooking', 'I love reading', 'Friends is my favorite show', 'I am a morning person', 'I am terrified of snakes'];

//   // Pick a random greeting.
//   const greeting = greetings[Math.floor(Math.random() * greetings.length)];

//   // Add it to the page.
//   const greetingContainer = document.getElementById('greeting-container');
//   greetingContainer.innerText = greeting;
// }
function getDataServlet() {
    fetch('/data')  // sends a request to /data
    .then(response => response.json()) // parses the response as JSON
    .then((greeting) => { // now we can reference the fields in here!
    // console.log(greeting.greetings);
        document.getElementById('greeting-container').innerText = greeting;
    });
}
$(document).ready(function (){
    $('nav a[href*="#"]').click(function () {
        $('html, body').animate({
            scrollTop: $($(this).attr('href')).offset().top - 100
        }, 2000);
    });
    $('#up').click(function() {
        $([document.documentElement, document.body]).animate({
            scrollTop: 0
        }, 2000);
    });
});

// function getRandomQuoteUsingArrowFunctions() {
//   fetch('/data').then(response => response.text()).then((quote) => {
//     document.getElementById('greeting-container').innerText = quote;
//   });
// }