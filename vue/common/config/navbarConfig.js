import {faShieldAlt} from "@fortawesome/free-solid-svg-icons/faShieldAlt";

export const navItem = [
  {
    key     : "user",
    title   : "User Management",
    auth    : ["uaa"],
    icon    : faShieldAlt,
    children: [
      {
        key  : "udefinition",
        title: "User Definition",
        icon : "fa-users",
        auth : ["nbr"],
        path : "/user"
      }
    ]
  }
]
