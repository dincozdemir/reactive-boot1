let moviesRequestStream = Rx.Observable.from(axios.get('/movies/'));

moviesRequestStream.subscribe(({ data }) => {
    // execute the request
    console.log(data);
    var responseStream = Rx.Observable.create(function (observer) {
        const eventSource = new EventSource('/movies/' + data[0].id + '/events');
        eventSource.onmessage = x => observer.next(x);
        eventSource.onerror = x => observer.error(console.log('EventSource failed'));
    });

    responseStream.subscribe(function({ data }) {
        // do something with the response
        console.log(data);
    });
});



if (false) {
    let movie = '';
    axios.get('/movies/')
        .then(function ({data}) {
            console.log(data);
            movie = data[1];
            var source = new EventSource('/movies/' + movie.id + '/events');

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
        });
} else {
    // Result to xhr polling :(
}