const submit = document.querySelector("#contactForm");

const contactDetails = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let subject = document.getElementById("subject").value;
  let message = document.getElementById("message").value;

  try {

    const response2 = await fetch("http://localhost:8080/contacts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, // Remove redundant method
      },
      body: JSON.stringify({
        contactName: name,
        contactEmail: email,
        subject: subject,
        message: message,
      }),
    });

    const data = await response2.json();
    console.log(data);
  } catch (error) {
    console.error("Error:", error.message);
  }
};

submit.addEventListener("submit", contactDetails);
