
if (!!window.EventSource) {
    var source = new EventSource('/movies/542c12e6-35cd-4995-b2f7-53c712064615/events');
} else {
    // Result to xhr polling :(
}

source.addEventListener('message', function(e) {
    console.log(e.data);
}, false);

source.addEventListener('open', function(e) {
    // Connection was opened.
}, false);

source.addEventListener('error', function(e) {
    if (e.readyState == EventSource.CLOSED) {
        // Connection was closed.
    }
}, false);