const submit = document.querySelector("#doctorForm");

const listDoctors = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let doctorName = document.getElementById("name").value;
  let speciality = document.getElementById("speciality").value;
  let location = document.getElementById("location").value;
  let contact = document.getElementById("contact").value;

  try {
    const response = await fetch("http://localhost:8080/doctors", {
      headers: {
        Authorization: authorizationHeader, // Keep this method
      },
    });

    const response2 = await fetch("http://localhost:8080/doctors", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, // Remove redundant method
      },
      body: JSON.stringify({
        name: doctorName,
        speciality: speciality,
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

submit.addEventListener("submit", listDoctors);