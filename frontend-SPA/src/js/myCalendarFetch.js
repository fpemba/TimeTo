import { displayMyPage } from "./myCalendar.js";

const getEventsByUserNameAndDay = () => {
    return fetch('http://localhost:8080/months/stumax7April2020/')
        .then(response => response.json())
        .then(monthJson => renderDaysByMonth(monthJson))
};

const renderDaysByMonth = (month) => {
    let monthLength = month.length;
    let currentDay = month.firstDayOfMonth;
    month.days.forEach(day => {
        let cell = document.querySelector(`.cell${currentDay}`);
        currentDay++;
        cell.innerText = day.dayNumber;
        cell.addEventListener('click', () => {
            const cellModal = document.createElement('div');
            cellModal.classList.add("cellModal");
            // let dayEventJSON = JSON.stringify(day.events);
            // cellModal.innerText = dayEventJSON;
            day.events.forEach(event => {
                const eventsList = document.createElement('ul');
                cellModal.appendChild(eventsList)
                const eventsListItem = document.createElement('li');
                const eventName = JSON.stringify(event.name);
                eventsListItem.innerText = event.startTime + ": " + eventName;
                eventsList.appendChild(eventsListItem);
                eventsListItem.addEventListener('click', () => {
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
                            // const newEventJson = {
                            //     "name": eventForm.value,
                            // }
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
                            displayMyPage();
                        })
                        const close = document.createElement("span");
                        close.classList.add("close");
                        close.innerHTML = "&times;";
                        cellModal.appendChild(close);
                        close.addEventListener('click', () => {
                            cellModal.style.display = "none";
                        })
                        })
                    })
                })
                const close = document.createElement("span");
                close.classList.add("close");
                close.innerHTML = "&times;";
                cellModal.appendChild(close);
                close.addEventListener('click', () => {
                    cellModal.style.display = "none";
                })
                const calendarCell = document.querySelector(".calendarCell");
                calendarCell.appendChild(cellModal);
                cellModal.style.display = "block";
            })
        });
    })
    // }


    // const renderDays = (currentDay, day) => {
    //     console.log("javascript is so good")
    // days.forEach(day=>{
    // console.log("no it isnt");
    // const cell3 = document.querySelector('.cell3');
    // const newDiv = document.createElement('div');
    // newDiv.innerText = day.dayNumber;
    // cell3.appendChild(newDiv);

    // })

    // }
}
    const calendarCell = document.querySelector('.calendarCell')
    console.log(calendarCell);
    getEventsByUserNameAndDay();

    export {
        getEventsByUserNameAndDay
    }
