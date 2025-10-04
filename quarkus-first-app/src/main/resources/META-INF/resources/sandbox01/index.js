import { useMyFetchClient } from "/my-fetch/index.js";

const value01Elem = document.getElementById("value01")
const value02Elem = document.getElementById("value02")

const get1ButtonElem = document.getElementById("get1Button")
const post1ButtonElem = document.getElementById("post1Button")



const fetchClient = useMyFetchClient()


get1ButtonElem.addEventListener("click", async() => {
	
	const value01 = value01Elem.value
	const value02 = value02Elem.value

	const resp = await fetchClient
	  .get("/sandbox01/get1")
	  .params({
	    value01,
	    value02
	  })
	  .execute();
})

post1ButtonElem.addEventListener("click", async() => {

const value01 = value01Elem.value
const value02 = value02Elem.value

const resp = await fetchClient
  .post("/sandbox01/post1")
  .jsonBody({
    value01,
    value02
  })
  .execute();
})
