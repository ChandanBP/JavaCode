from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.multiclass import OneVsRestClassifier
import numpy as np

#First read E and T
line=input()
T,E=line.split()
E=int(E)
T=int(T)

vocab=set()
questions=dict()
q=[]
for t in range(T):
    line=input()
    topics=[0 for i in range(251)]
    topicList=line.split()
    N=int(topicList[0])
    for n in range(1,N+1):
        topics[int(topicList[n])]=1
    question=input()
    q.append(question)
    wordsInQuestion=question.split()
    for word in wordsInQuestion:
        vocab.add(word)
    questions[question]=topics

test=[]
ans=[]
for t in range(E):
    s=input()
    test.append(s)
    ans.append(s)     
    
vectorizer = TfidfVectorizer(ngram_range=(1,1), max_df=0.8)
vectorizer.fit(vocab)

#train the model for training set
xtrain=[]
ytrain=[]
for key in q:
    xtrain.append(key)
    ytrain.append(questions.get(key))
 
logr = LogisticRegression(C=4, class_weight='auto')        
model = OneVsRestClassifier(logr)
xtrain=vectorizer.transform(xtrain)
ytrain=np.array(ytrain)
model.fit(xtrain, ytrain)

test=vectorizer.transform(test)
pred=model.predict_proba(test)
j=0
for row in pred:
    row=sorted(range(len(row)), key=lambda k: row[k],reverse=True)
    j=j+1
    for i in range(10):
        print (row[i],end=' ')
    print()