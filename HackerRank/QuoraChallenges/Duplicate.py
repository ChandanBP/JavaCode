import json
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression

Q=int(input())

questions=dict()
vocab=set()
rawDocs=[]
for numJson in range(Q):
    line=input()
    jsonData=json.loads(line)
    s=""
    
    vC=str(jsonData['view_count'])
    vocab.add(vC)
    s+=vC+" "
    
    qT=jsonData['question_text']
    rawDocs.append(qT)
    s+=qT+" "
    
    t=[]
    for topic in jsonData['topics']:
        name=topic.get('name')
        vocab.add(name)
        t.append(name)
        s+=name+" "
    
    fC=str(jsonData['follow_count'])
    vocab.add(fC)
    s+=fC+" "
    
    age=str(jsonData['age'])
    vocab.add(age)
    s+=age
    questions[jsonData['question_key']]=s
  
rawDocs.extend(vocab)
vectorizer = TfidfVectorizer(ngram_range=(1,3), analyzer='char', max_df=0.5,sublinear_tf=True)
vectorizer.fit(rawDocs)

#Next read D
D=int(input())
train=[]
targetClass=[]
for j in range(1,D+1):
    Q1,Q2,Class=input().split()
    train.append(questions[Q1]+' '+questions[Q2])
    targetClass.append(int(Class))
    
N=int(input())
test=[]
res=[]
for n in range(1,N+1):
    Q1,Q2=input().split()
    test.append(questions[Q1]+' '+questions[Q2])
    res.append(Q1+' '+Q2)
 
train = vectorizer.transform(train)
model = LogisticRegression(C=2.0)
model.fit(train, targetClass) 
    
test=vectorizer.transform(test)
predict=model.predict(test)


for n in range(N):
    print (res[n],predict[n])
