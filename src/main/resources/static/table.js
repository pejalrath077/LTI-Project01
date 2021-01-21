
window.onload = function () {
    fetch('https://cors-anywhere.herokuapp.com/https://lti-project-01.herokuapp.com/getRequestForm')
        .then(response => response.json())
        .then(json => buildTable(json))
}

function buildTable (arr) {
    for (let i = 0; i < arr.length; i++) {
        let row = `
            <th scope="row">${arr[i].id}</th>
            <td>${arr[i].system}</td>
            <td>${arr[i].issues}</td>
            <td>${arr[i].reportedDate}</td>
            <td>${arr[i].criticality}</td>
            <td>${arr[i].pendingWith}</td>
            <td>${arr[i].status}</td>
            <td>${arr[i].verifiedBy}</td>
            <td>${arr[i].targetDate}</td>
            <td>${arr[i].closureDate}</td>
            <td>${arr[i].remark}</td>
            <td>${arr[i].reportedBy}</td>
            <td><button id="button-${arr[i].id}" type="button" class="btn btn-warning">update</button></td>
        `
        let tr = document.createElement('tr');
        tr.setAttribute('id', i);
        tr.innerHTML = row;
        document.getElementById('table-body').appendChild(tr);
    }
    // how to add & remove classes:
    // document.getElementById('example-add').classList.add('class-1');
    // document.getElementById('example-remove').classList.remove('class-2');
}