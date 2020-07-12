import {notification} from "antd"

export const showError = msg => {
  notification["error"]({
    message: "Error",
    description: msg,
    placement: "bottomRight"
  })
}

export const showSuccess = msg => {
  notification["success"]({
    message: "Success",
    description: msg,
    placement: "bottomRight"
  })
}

export const showWarning = msg => {
  notification["warning"]({
    message: "Warnning",
    description: msg,
    placement: "bottomRight"
  })
}

export const isNotEmpty = str => {
  str = str.toString()
  return str && str.length > 0
}

export const isEmpty = str => {
  return !isNotEmpty(str)
}

export const cleanObject = obj => {
  Object.keys(obj).forEach(item => {
    if (!obj[item]) {
      delete obj[item]
    }
  })
  return obj
}

export const getBase64 = (img, callback) => {
  const reader = new FileReader()
  reader.addEventListener("load", () => callback(reader.result))
  reader.readAsDataURL(img)
}

export const emptyObject = obj => {
  Object.keys(obj).forEach(item => {
    obj[item] = ""
  })
  return obj
}

export const roundNumber = number => {
  return parseFloat(number).toFixed(2)
}
