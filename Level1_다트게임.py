# 첫번째로 푼 방식
def solution(dartResult):
    score = []
    for i,v in enumerate(dartResult):
      try: 
        if v == '0' and dartResult[i-1] == '1':
          score[-1] = 10
        else:
          score.append(int(v))

      except:
        if v == 'D':
          score[-1] **= 2
        elif v == 'T':
          score[-1] **= 3

        if v == '*':
          score[-1] *= 2
          if len(score) != 1:
            score[-2] *= 2
        elif v == '#':
          score[-1] *= -1
    answer = sum(score)
    return answer
  
  
# 정규화식 사용
import re

def solution(dartResult):
    bonus = {'S' : 1, 'D' : 2, 'T' : 3}
    option = {'' : 1, '*' : 2, '#' : -1}
    p = re.compile('(\d+)([SDT])([*#]?)')
    dart = p.findall(dartResult)
    print(dart)
    for i,v in enumerate(dart):
      if v[2] == '*':
        dart[i-1] *= 2
      dart[i] = int(v[0]) ** bonus[v[1]] * option[v[2]]
    
    return sum(dart)
