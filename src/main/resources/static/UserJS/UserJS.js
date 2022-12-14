async function displayUserData() {

    await fetch('/rest/user_page')
        .then(response => response.json())
        .then(json => getUserData(json))
        .catch(error => alert(error));
}

function getUserData(user) {

    let assignedRoles = [];
    for (let role of user.roles) {
        assignedRoles.push(" " + role.roleName)
    }

    let row =
        `<tr>
            <td> ${user.id} </td>
            <td> ${user.name} </td>
            <td> ${user.surname} </td>
            <td> ${user.username} </td>
            <td> ${user.password} </td>
            <td> ${assignedRoles} </td>
         </tr>`;

    document.getElementById('user_info').innerHTML = row;
}

displayUserData();


