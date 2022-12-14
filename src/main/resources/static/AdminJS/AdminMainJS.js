
async function showAllUsers() {

    await fetch('/rest/admin/users')
        .then(response => response.json())
        .then(json => getAllUsers(json))
        .catch(error => alert(error));
}

function getAllUsers(usersList) {

    let table = "";
    for (let user of usersList) {

        let assignedRoles = [];

        for (let role of user.roles) {
            assignedRoles.push(" " + role.roleName)
        }

        table +=
            `<tr>
                 <td> ${user.name} </td>
                 <td> ${user.surname} </td>
                 <td> ${user.username} </td>
                 <td> ${assignedRoles} </td>
                 <td>
                 <button class='btn btn-primary'
                 data-toggle='modal'
                 data-target='#edit-modal'
                 onclick='editData(${user.id})'> Edit
                 </button>
                 </td>
                 <td>
                 <button class='btn btn-danger'
                    data-toggle='modal'
                    data-target='#delete-modal'
                    onclick='deleteData(${user.id})'> Delete
                 </button>
                 </td>
            </tr>`;
    }
    document.getElementById('admin_main').innerHTML = table;
}

showAllUsers();
