
const saveForm = document.getElementById('new-user-panel');
const saveEntry = document.getElementById('save-new');
const roleChoice = document.getElementById('new-assigned_roles').selectedOptions;

saveEntry.addEventListener('click', newUserEntry);

async function newUserEntry(event) {

    event.preventDefault();
    let assignedRoles = [];

    for (let i = 0; i < roleChoice.length; i++) {
        assignedRoles.push({id: roleChoice[i].value})
    }

    const data =
        {
            name: document.getElementById('new-name').value,
            surname: document.getElementById('new-surname').value,
            username: document.getElementById('new-login').value,
            password: document.getElementById('new-password').value,
            roles: assignedRoles
        }

        await fetch('/rest/admin/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(data)
        }).then(() => {
            saveForm.reset();
            showAllUsers();
            $("#all-users-tab").click()})
            .catch(error => alert(error));
}

