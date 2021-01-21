
function createIssue () {

    const system = document.getElementById('system').value
    const issues = document.getElementById('issues').value
    const reportedDate = document.getElementById('reportedDate').value
    const criticality = document.getElementById('criticality').value
    const pendingWith = document.getElementById('pendingWith').value
    const status = document.getElementById('status').value
    const verifiedBy = document.getElementById('verifiedBy').value
    const targetDate = document.getElementById('targetDate').value
    const closureDate = document.getElementById('closureDate').value
    const remark = document.getElementById('remark').value
    const reportedBy = document.getElementById('reportedBy').value

    const json = {
        id: 0,
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
        .then(json => console.log(json))

}