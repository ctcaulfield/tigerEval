import requests
import simplejson
import pymysql

conn = pymysql.connect(host='localhost',port=3306, user='root',password='student',db='catTest')
a = conn.cursor()

#list of ist professors
#profList = []

#listProf = requests.get('http://ist.rit.edu/api/people')
currentTerm = '2165' # this will change or have to get past terms
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
	a.execute(query)

def constructQuery(fieldList):
	query = "insert into COURSE values("
	for x in range(0,len(fieldList)-1):
		query += "'" + str(fieldList[x]) + "',"
	query += "'" + fieldList[5] + "');"
	return query

def getFromRITAPI(url):
	r = requests.get(url)
	c = r.content
	j = simplejson.loads(c)
	for item in j:
	    section = item["section"] #iste-501-01
	    groupname = item["groupname"] #rit-section-2165-iste-501-01
	    term = item["term"] #2165
	    name = item["name"] #Senior Development Project
	    for ins in item["instructors"]: #sjzics
	    	instructor = ins
	    numStudents = item["students"] #40
	    for meeting in item["meetings"]:
	    	meetingId = meeting["id"]
	    	meetingStart = meeting["start"]
	    	meetingEnd = meeting["end"]
	    	meetingGen = meeting["meeting"]
	    	meetingType = meeting["meetingtype"]
	    	meetingFac = meeting["facilitator"] #GCCIS
	    	room_id = meeting["room_id"] # why
	    	created = meeting["created_at"]
	    	updated = meeting["updated_at"]
	return section, term, name, instructor, numStudents, meetingFac

profList = getProfessors("http://ist.rit.edu/api/people")
for prof in profList:
	url = "http://api.rit.edu/v1/faculty/"+prof+"/courses/&RITAuthorization=0a66ff145ca0ee53807a096eda307e5901801185"
	fieldList = getFromRITAPI(url)
	print constructQuery(fieldList)
	executeCommand(constructQuery(fieldList))
a.commit()
a.close()
conn.close()


