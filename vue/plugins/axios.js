import {BASE_PATH} from "~/common/constant/api/path";

export default function ({$axios, store, redirect, dispatch}, inject) {
  const api = $axios.create(BASE_PATH,
                            {
                              headers: {
                                'Accept'      : 'application/vnd.api+json',
                                'Content-Type': 'application/vnd.api+json',
                                common        : {
                                  'Accept'      : 'application/vnd.api+json',
                                  'Content-Type': 'application/vnd.api+json'
                                },
                                post: {
                                  'Accept'      : 'application/vnd.api+json',
                                  'Content-Type': 'application/vnd.api+json'
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
    request.headers.post['Content-Type']   = "application/json"
    request.headers.common['Content-Type'] = "application/json"
    return request
  })


  inject("api", api)
}
