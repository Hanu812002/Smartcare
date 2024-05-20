const submit = document.querySelector("#data-list");
  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  // Make a fetch request to the backend API endpoint with basic authentication
  fetch('/api/data', {
    headers: {
      'Authorization': authorizationHeader,
      'Content-Type': 'application/json'
    }
  })
    .then(response => {
      // Check if the response is successful
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      // Parse the JSON response
      return response.json();
    })
    .then(data => {
      // Manipulate the 'data' and render it in your UI
      renderData(data);
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });

  // Function to render data in the UI
  function renderData(data) {
    // Assuming 'data' is an array of objects
    const dataList = document.getElementById('data-list');

    // Clear existing content
    dataList.innerHTML = '';

    // Loop through the data and create HTML elements to display it
    data.forEach(item => {
      const listItem = document.createElement('li');
      listItem.textContent = item.name; // Assuming 'name' is a property of each object
      dataList.appendChild(listItem);
    });
  }
submit.addEventListener("click", listPatients);