import {
    user
} from './app.js'

const getFriendCompareEventsByUserNameAndDay = (user) => {
    return fetch(`http://localhost:8080/months/${user.username}April2020/`)
        .then(response => response.json())
        .then(monthJson => renderDaysByMonth(monthJson))
};

const renderCell = (day, currentDay) => {
    let cell = document.querySelector(`.friendCell${currentDay}`);
    cell.innerText = day.dayNumber;
    cell.addEventListener('click', () => {
        const cellModal = document.createElement('div');
        cellModal.classList.add("cellModal");
        
        day.events.forEach(event => {
            renderEventsByDay(cellModal, event);
        })
    });
}

const renderDaysByMonth = (month) => {

    let currentDay = month.firstDayOfMonth;
    month.days.forEach(day => {
        renderCell(day, currentDay);
        currentDay++;
    })
}
const renderEventsByDay = (cellModal, event) => {
    const eventsList = document.createElement('ul');
    cellModal.appendChild(eventsList)
    const eventsListItem = document.createElement('li');
    const eventName = JSON.stringify(event.name);
    eventsListItem.innerText = event.startTime + ": " + eventName;
    eventsList.appendChild(eventsListItem);
    eventsListItem.addEventListener('click', () => {
        renderEventDetails(cellModal, event);
    })
    const close = document.createElement("span");
    close.classList.add("close");
    close.innerHTML = "&times;";
    cellModal.appendChild(close);
    close.addEventListener('click', () => {
        cellModal.style.display = "none";
    })
   

    const friendsCompareCalendarCell = document.querySelector(".friendsCompareCalendarCell");
    // const pageContainer = document.querySelector(".container");
    friendsCompareCalendarCell.append(cellModal);
    cellModal.style.display = "block";

  
}
const renderEventDetails = (cellModal, event) => {
    while (cellModal.firstChild) {
        cellModal.removeChild(cellModal.firstChild);
    }
    const eventTitle = document.createElement("h1");
    eventTitle.innerText = event.name;
    cellModal.appendChild(eventTitle);
    const startTime = document.createElement("p")
    startTime.innerText = "Start time: " + event.startTime;
    eventTitle.appendChild(startTime);
    const endTime = document.createElement("p");
    endTime.innerText = "End time: " + event.endTime;
    startTime.appendChild(endTime);
    const space = document.createElement('p');
    endTime.appendChild(space);
    const changeScheduleButton = document.createElement('button');
    changeScheduleButton.classList.add('changeScheduleButton');
    changeScheduleButton.innerText = "Change schedule";
    space.appendChild(changeScheduleButton);
    changeScheduleButton.addEventListener('click', () => {
        submitChangedSchedule(cellModal, event);
    })
    const close = document.createElement("span");
    close.classList.add("close");
    close.innerHTML = "&times;";
    cellModal.appendChild(close);
    close.addEventListener('click', () => {
        getFriendCompareEventsByUserNameAndDay(user);
        cellModal.style.display = "none";
    })
}
const submitChangedSchedule = (cellModal, event) => {
    const eventForm = document.createElement('input');
    eventForm.classList.add('eventForm');
    eventForm.setAttribute('placeholder', 'Event name');
    cellModal.appendChild(eventForm);
    const space = document.createElement('p');
    cellModal.appendChild(space);
    const submitButton = document.createElement('button');
    submitButton.classList.add('submitButton')
    submitButton.innerText = "Submit";
    cellModal.appendChild(submitButton);
    submitButton.addEventListener('click', () => {
        let newName = eventForm.value;
        let id = event.id;
        fetch(`http://localhost:8080/events/${id}/`, {
                method: "PATCH",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: newName
            })
            .then(response => response.json())
        while (cellModal.firstChild) {
            cellModal.removeChild(cellModal.firstChild);
        }
        const eventTitle = document.createElement("h1");
        eventTitle.innerText = eventForm.value;
        cellModal.appendChild(eventTitle);
        const startTime = document.createElement("p")
        startTime.innerText = "Start time: " + event.startTime;
        eventTitle.appendChild(startTime);
        const endTime = document.createElement("p");
        endTime.innerText = "End time: " + event.endTime;
        startTime.appendChild(endTime);
        const space = document.createElement('p');
        endTime.appendChild(space);
        const changeScheduleButton = document.createElement('button');
        changeScheduleButton.classList.add('changeScheduleButton');
        changeScheduleButton.innerText = "Change schedule";
        space.appendChild(changeScheduleButton);
        const close2 = document.createElement("span");
        close2.classList.add("close");
        close2.innerHTML = "&times;";
        cellModal.appendChild(close2);
        close2.addEventListener('click', () => {
            getFriendCompareEventsByUserNameAndDay(user);
            cellModal.style.display = "none";
        })

    })
}

// getEventsByUserNameAndDay();

export {
    getFriendCompareEventsByUserNameAndDay
}