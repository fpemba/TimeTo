const getEventsByUserNameAndDay = ()=> {
    return fetch('http://localhost:8080/events/{username}/{day}/')
        .then(response => response.json())
        .then(eventsJson => renderEvents(eventsJson))
}

const renderEvents = (events) => {
    events.forEach(event=>{
        const cell3 = document.querySelector('.cell3');
        console.log(events);
        cell3.innerText = event.name;
    })
    
}

export{getEventsByUserNameAndDay}