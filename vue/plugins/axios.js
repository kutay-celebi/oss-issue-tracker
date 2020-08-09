import {BASE_PATH} from "~/common/constant/api/path";

export default function ({$axios, store, redirect, dispatch}, inject) {
  const api = $axios.create(BASE_PATH,
                            {
                              headers: {
                                post: {
                                  "content-type": "application/json",
                                  "Accept"      : "application/json"
                                }
                              },
                              timeout: 60000
                            })
  api.setBaseURL(BASE_PATH)

  api.onError((error) => {
    if (error.response.status === 401) {
      redirect("/")
    }
  })

  api.onRequest(request => {
    console.log('[ REQUEST ]' + request.url)
    if (store.state.auth) {
      request.headers.common['Authorization'] = "Bearer " + store.state.auth.user.access_token
    }

    return request
  })


  inject("api", api)
}
