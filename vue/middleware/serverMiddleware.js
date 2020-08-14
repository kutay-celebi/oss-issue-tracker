export default function (req, res, next) {
  console.log("Work Server Middleware")
  next()
}
