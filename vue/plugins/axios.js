import {BASE_PATH} from "~/common/constant/api/path";

export default function ({$axios, store}, inject) {
  const api = $axios.create(BASE_PATH,
    {
      headers: {
        "content-type": "application/json",
        "Accept": "application/json"
      },
      timeout: 60000
    })
  api.setBaseURL(BASE_PATH)

  inject("api", api)
}
