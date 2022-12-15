
const editButton = document.getElementById('edit-edit');
const editId = document.getElementById('edit-id');
const editName = document.getElementById('edit-name');
const editSurname = document.getElementById('edit-surname');
const editLogin = document.getElementById('edit-login');
const editPassword = document.getElementById('edit-password');
const rolesToEdit = document.getElementById('edit-assigned_roles');

async function editData(id) {

    await fetch(`/rest/admin/users/${id}`)
        .then(mainResponseErrorHandler)
        .then(entry => {
            editId.value = `${entry.id}`;
            editName.value = `${entry.name}`;
            editSurname.value = `${entry.surname}`;
            editLogin.value = `${entry.username}`
        }).catch(error => alert(error));
}

editButton.addEventListener('click', editUser)

async function editUser(event) {

    event.preventDefault();

    let updatedRoles = [];

    for (let i = 0; i < rolesToEdit.length; i++) {
        if (rolesToEdit.options[i].selected) {
            updatedRoles.push({id: rolesToEdit.options[i].value});
        }
    }

    let data = {
        id: document.getElementById('edit-id').value,
        name: document.getElementById('edit-name').value,
        surname: document.getElementById('edit-surname').value,
        username: document.getElementById('edit-login').value,
        password: document.getElementById('edit-password').value,
        roles: updatedRoles
    }

    let editing = {
        method: 'PUT',
        headers: {
            "Content-Type": 'application/json'
        },
        body: JSON.stringify(data)
    }

    await fetch(`/rest/admin/users/${editId.value}`, editing)
        .then(() => {
            clearPassword();
            $("#edit-close").click();
            showAllUsers();
        })
}

function clearPassword() {
    if(editPassword.value !== "") {
        editPassword.value = "";
    }
}