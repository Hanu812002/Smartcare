const submit = document.querySelector("#doctorRegistrationForm");

const registerDoctor = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let doctorName = document.getElementById("name").value;
  let specialty = document.getElementById("specialty").value;
  let education = document.getElementById("education").value;
  let experience = document.getElementById("experience").value;
  let location = document.getElementById("location").value;
  let contact = document.getElementById("contact").value;
  let email = document.getElementById("email").value;
  let hospital = document.getElementById("hospital").value;
  let paassword = document.getElementById("password").value;
  let image = document.getElementById("image").value;

  try {
    const response = await fetch("http://localhost:8080/doctors", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, 
      },
      body: JSON.stringify({
        name: doctorName,
        speciality: specialty,
        education: education,
        experience: experience,
        location: location,
        contact: contact,
        hospital: hospital,
        email: email,
        pwd: paassword,
        file: image,
      }),
    });

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error("Error:", error.message);
  }
};

submit.addEventListener("submit", registerDoctor);
