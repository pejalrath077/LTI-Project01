let count = 0;
window.onload = function () {
    fetch('https://cors-anywhere.herokuapp.com/https://lti-project-01.herokuapp.com/getRequestForm')
        .then(response => response.json())
        .then(json => {
            buildTable(json);
            console.log(json);
            console.log(typeof json.length);
            count = json.length;
            console.log(count);
        });
}

function updateIssue(id) {
    console.log("update button clicked " + id);
}
function createIssue() {

    const id = count;
    const system = document.getElementById('system').value;
    const issues = document.getElementById('issues').value;
    const reportedDate = document.getElementById('reportedDate').value;
    const criticality = document.getElementById('criticality').value;
    const pendingWith = document.getElementById('pendingWith').value;
    const status = document.getElementById('status').value;
    const verifiedBy = document.getElementById('verifiedBy').value;
    const targetDate = document.getElementById('targetDate').value;
    const closureDate = document.getElementById('closureDate').value;
    const remark = document.getElementById('remark').value;
    const reportedBy = document.getElementById('reportedBy').value;

    const json = {
        id: id,
        system: system,
        issues: issues,
        reportedDate: reportedDate,
        criticality: criticality,
        pendingWith: pendingWith,
        status: status,
        verifiedBy: verifiedBy,
        targetDate: targetDate,
        closureDate: closureDate,
        remark: remark,
        reportedBy: reportedBy,
    }

    fetch('https://cors-anywhere.herokuapp.com/https://lti-project-01.herokuapp.com/createRequestForm', {
        method: 'post',
        headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
        body: JSON.stringify(json)
    })
        .then(response => response.json())
        .then(json => {
            console.log(json);
            location.reload();
        })
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
            <td><button id="button-${arr[i].id}" onclick="updateIssue(${arr[i].id})" button" class="btn btn-warning">update</button></td>
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
