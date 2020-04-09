




const getEventsByUserNameAndMonth = ()=> {
    fetch('http://localhost:8080/events/{username}/{month}/')
        .then(response => response.json())
        .then(eventsJson => renderEvents(eventsJson))
}

const renderEvents = (events) => {
    const cell1 = document.querySelector('.cell1');
}