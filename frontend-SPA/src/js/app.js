import {displayHome} from './homePageCreator.js';
import {displayMyPage} from './myCalendar.js';
import { displayComparePage } from './comparePageCreator.js';

displayHome();

const loginButton = document.querySelector(".loginButton");
loginButton.addEventListener('click', ()=>{displayMyPage()});

const hamCompareLink = document.querySelector(".compare_link");
hamCompareLink.addEventListener('click', ()=>{displayComparePage()});

// const monthPicture = document.querySelector(".calendar");
// monthPicture.addEventListener('click', ()=>{displayComparePage()});

