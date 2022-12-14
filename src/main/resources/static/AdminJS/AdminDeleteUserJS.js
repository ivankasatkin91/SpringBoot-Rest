
const delButton = document.getElementById('delete-delete');
const delId = document.getElementById('delete-id');
const delName = document.getElementById('delete-name');
const delSurname = document.getElementById('delete-surname');
const delLogin = document.getElementById('delete-login');

async function deleteData(id) {

    await fetch(`/rest/admin/users/${id}`)
        .then(response => response.json())
        .then(entry => {
            delId.value = `${entry.id}`;
            delName.value = `${entry.name}`;
            delSurname.value = `${entry.surname}`;
            delLogin.value = `${entry.username}`
        }).catch(error => alert(error));
}

delButton.addEventListener('click', deleteUser)

async function deleteUser(event) {

    event.preventDefault();

    let deletion = {
        method: 'DELETE',
        headers: {
            "Content-Type": "application/json"
        }
    }

    await fetch(`/rest/admin/users/${delId.value}`, deletion)
        .then(() => {
            $("#delete-close").click();
            showAllUsers();
        })
        .catch(error => alert(error));
}


