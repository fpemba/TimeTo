import {displayHome} from './homePageCreator.js';
import {displayMyPage} from './myCalendar.js';
import { displayComparePage } from './comparePageCreator.js';

displayHome();

const loginButton = document.querySelector(".loginButton");
loginButton.addEventListener('click', ()=>{displayMyPage()});

const monthPicture = document.querySelector(".calendar");
monthPicture.addEventListener('click', ()=>{displayComparePage()});

