@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.rest.*

def usernames = ["3rickDJ", "Neodevelop"]
def API_KEY = new File('/home/erick/Code/repos/diaspora', 'ENV').collect{it}.join("")
def client = new RESTClient("https://api.github.com")
def responses = usernames.collect{
    client.get(path:"users/$it/followers", headers:["Authorization" :"token $API_KEY"])
    }
// println responses[0].json
println responses[1].json
assert [200,200] == responses*.statusCode
// println responses[0].json*.login.intersect(responses[1].json*.login)
