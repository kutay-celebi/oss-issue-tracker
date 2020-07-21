import {BASE_PATH} from "~/common/constant/api/path";

export default function ({$axios, store, redirect, dispatch}, inject) {
  const api = $axios.create(BASE_PATH,
                            {
                              headers: {
                                "content-type": "application/json",
                                "Accept"      : "application/json"
                              },
                              timeout: 60000
                            })
  api.setBaseURL(BASE_PATH)

  api.onError((error) => {
    if (error.response.status === 401) {
      redirect("/")
    }
  })


  inject("api", api)
}
