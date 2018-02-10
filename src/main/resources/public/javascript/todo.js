function getAllTodos() {
  console.log("Getting some todos.");

  var theUrl = "/api/todos";
  var isFiltered = false;
  var filter = "?";

  if(document.getElementById("_id").value != ""){
    filter = filter + "_id=" + document.getElementById("_id").value;
    isFiltered = true;
  }
  if(document.getElementById("owner").value != ""){
    if(isFiltered = true){
      filter = filter + "&";
    }
    filter = filter + "owner=" + document.getElementById("owner").value;
    isFiltered = true;
  }


  if(isFiltered){
    theUrl = theUrl+filter;
  }
  var HttpThingy = new HttpClient();
  HttpThingy.get(theUrl, function(returned_json){
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function(aUrl, aCallback){
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function(){

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
