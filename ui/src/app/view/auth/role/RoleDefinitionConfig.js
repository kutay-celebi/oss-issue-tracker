import {PATH_ROLE_DEFINITION} from "../../../constants";
import RoleDefinition from "./RoleDefinition";

export const RoleDefinitionConfig = {
    settings: {},
    auth    : ['uaa'],
    routes  : [
        {
            path     : PATH_ROLE_DEFINITION,
            component: RoleDefinition,
            navbar   : {
                id   : "role-definition",
                level: 2,
                title: "Role Definition" // todo with translation
            },
        }

    ]
};