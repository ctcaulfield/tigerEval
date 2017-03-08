import requests
import simplejson
import pymysql

#conn = pymysql.connect(host='localhost',port=3306, user='root',password='student',db='catTest')
#a = conn.cursor()

currentTerm = '2165' # this will change or have to get past terms
termList = []
def getProfessors(url):
	#get professors, put in list, return list
	profList = []
	r = requests.get(url)
	c = r.content
	j = simplejson.loads(c)
	for item in j["faculty"]:
		username = item["username"]
		profList.append(username)
		name = item["name"]
		email = item["email"]
	return profList

def executeCommand(query):
#	a.execute(query)

def getFromRITAPI(url):
	r = requests.get(url)
	c = r.content
	j = simplejson.loads(c)
	for item in j:
		query = "insert into COURSE values('" + str(item["section"]) + "','" + str(item["term"]) + "','" + str(item["name"]) + "','" + str(item["instructors"][0]) + "','" + str(item["students"]) + "','GCCIS');"
		return query

profList = getProfessors("http://ist.rit.edu/api/people")
for prof in profList:
	url = "http://api.rit.edu/v1/faculty/"+prof+"/courses/&RITAuthorization=0a66ff145ca0ee53807a096eda307e5901801185"
#	executeCommand(getFromRITAPI(url));
	print getFromRITAPI(url));
#a.commit()
#a.close()
#conn.close()


