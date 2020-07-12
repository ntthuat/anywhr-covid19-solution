import axios from 'axios'

const BASE_URL = 'http://localhost:8080'

export const callAPI = (endpoint, method = 'get', data) => {
  return new Promise((resolve, reject) => {
    axios({
      method,
      url: `${BASE_URL}${endpoint}`,
      data
    })
      .then(res => resolve(res.data))
      .catch(err => {
        reject({
          status: (err.response && err.response.status) || '',
          message: err.message || ''
        })
      })
  })
}
