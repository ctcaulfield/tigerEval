import requests
import simplejson
import pymysql

term = '2165' # this will change or have to get past terms
termList = []

counter = 0

connection = pymysql.connect(host='localhost',
				user='root',
				password='student',
				db='catTest',
				cursorclass=pymysql.cursors.DictCursor)

def getProfessors(url):
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

profList = getProfessors("http://ist.rit.edu/api/people")
for prof in profList:
	url = "http://api.rit.edu/v1/faculty/"+prof+"/courses/&RITAuthorization=0a66ff145ca0ee53807a096eda307e5901801185"
	#url = "http://api.rit.edu/v1/faculty/"+prof+"/courses?term="+term+"&RITAuthorization=0a66ff145ca0ee53807a096eda307e5901801185"
	reqs = requests.get(url)
	content = reqs.content
	json = simplejson.loads(content)
	for item in json:
		with connection.cursor() as cursor:
			query = "insert into COURSE values('" + str(item["section"]) + "','" + str(item["term"]) + "','" +\
				str(item["name"]) + "','" + str(item["instructors"][0]) + "','" + str(item["students"]) + "','GCCIS');"
			cursor.execute(query)
			connection.commit()
			counter = counter + 1
			print "Record for " + item['section'] + " inserted."
			
print "Inserted " + counter + " records into the database."
connection.close()	
#There are 290 courses being taught by 33 professors among the IST department

