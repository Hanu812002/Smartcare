const submit = document.querySelector("#patientRegistrationForm");

const patientRegistration = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let patientName = document.getElementById("name").value;
  let age = document.getElementById("age").value;
  let medicalHistory = document.getElementById("medicalHistory").value;
  let contact = document.getElementById("contact").value;
  let image = document.getElementById("image").value;


  try {
    const response2 = await fetch("http://localhost:8080/patients", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, // Remove redundant method
      },
      body: JSON.stringify({
        name: patientName,
        age: age,
        medicalHistory: medicalHistory,
        contact: contact,
        file: image,
      }),
    });

    const data = await response2.json();
    console.log(data);
  } catch (error) {
    console.error("Error:", error.message);
  }
};

submit.addEventListener("submit", patientRegistration);
