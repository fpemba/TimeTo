import {displayHome} from './homePageCreator.js';
import {displayMyPage} from './myCalendar.js';

displayHome();
const loginButton = document.querySelector(".loginButton");
loginButton.addEventListener('click', displayMyPage())
console.log("BUTTON!")
