const submit = document.querySelector("#rex");

const listDocument = async (event) => {
  event.preventDefault();

  const username = "john";
  const password = "test123";
  const authorizationHeader = "Basic " + btoa(username + ":" + password);

  let date = document.getElementById("date").value;
  let documentType = document.getElementById("doc_type").value;
  let description = document.getElementById("description").value;

  try {
    const response = await fetch("http://localhost:8080/documents", {
      headers: {
        Authorization: authorizationHeader, // Keep this method
      },
    });

    const response2 = await fetch("http://localhost:8080/documents", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: authorizationHeader, // Remove redundant method
      },
      body: JSON.stringify({
        date: date,
        documentType: documentType,
        description: description,
      }),
    });

    const data = await response2.json();
    console.log(data);
  } catch (error) {
    console.error("Error:", error.message);
  }
};

submit.addEventListener("submit", listDocument);