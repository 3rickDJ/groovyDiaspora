package diaspora
import wslite.rest.*


def usernames = ["3rickDJ", "ghector6"]
def API_KEY = new File('/home/erick/Code/repos/diaspora', 'ENV').collect{it}.join("")
def client = new RESTClient("https://api.github.com")
def responses = usernames.collect{
    client.get(path:"users/$it/followers", headers:["Authorization" :"token $API_KEY"])
    }
assert [200,200] == responses*.statusCode
// println responses[0].json*.login.intersect(responses[1].json*.login)
 def followers = responses[0].json*.login.intersect(responses[1].json*.login)
println followers
 def resultado = followers.collect{
     List  a = client.get(path:"users/$it/followers", headers:["Authorization" :"token $API_KEY"]).json*.login
     a = followers.intersect(a)


    return ["$it":a]
     }
resultado.each{println it}
