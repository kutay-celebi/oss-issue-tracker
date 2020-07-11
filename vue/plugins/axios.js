import {BASE_PATH} from "~/common/constant/api/path";

export default function ({$axios, redirect}, inject) {
  const api = axios.create({
                             baseURL: BASE_PATH,
                             headers: {
                               "content-type": "application/json",
                               "Accept"      : "application/json"
                             },
                             timeout: 60000
                           })
  inject("api", api)
}
