import { useMyFetchClient } from "/my-fetch/index.js";

const messageElem = document.getElementById("message")
const codeElem = document.getElementById("code")


const registerButtonElem = document.getElementById("registerButton")


const fetchClient = useMyFetchClient()

registerButtonElem.addEventListener("click", async() => {

  const message = messageElem.value
  const code = codeElem.value

  const resp = await fetchClient
    .post("/sandbox02/register")
    .jsonBody({
      message,
	  code
    })
    .execute();
  
  if (resp.ok) {
	console.log(resp)
	messageElem.value = "";
  }
})
