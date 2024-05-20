const submit = document.querySelector("#myForm");

const listHospitals = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let hospitalName = document.getElementById("name").value;
  let location = document.getElementById("speciality").value;
  let contact = document.getElementById("contact").value;

  try {
    const response = await fetch("http://localhost:8080/hospitals", {
      headers: {
        Authorization: authorizationHeader, // Keep this method
      },
    });

    const response2 = await fetch("http://localhost:8080/hospitals", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, // Remove redundant method
      },
      body: JSON.stringify({
        name: hospitalName,
        location: location,
        contact: contact,
      }),
    });

    const data = await response2.json();
    console.log(data);
  } catch (error) {
    console.error("Error:", error.message);
  }
};

submit.addEventListener("submit", listHospitals);
