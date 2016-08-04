import sqlite3

class abstractMapper(object):
    def __init__(self):
        self.loaded_map = {}
        try:
            self.conn = sqlite3.connect('../dry.sqlite3')
        except:
            print "fail to connection"

    def findStatement(self):
        pass

    def find(self, domain_id):
        pass

    def abstractFind(self, domain_id):
        if domain_id in self.loaded_map:
            return loaded_map[domain_id]
        try:
            cursor = self.conn.cursor()
            query = self.findStatement()
            cursor.execute(query, (domain_id,))
            rs = cursor.fetchone()
            result = self.load(rs)
            return result
        except Exception as e:
            print e
            raise
        finally:
            self.conn.close()


    def load(self, rs):
        domain_id = rs[0]
        if domain_id in self.loaded_map:
            return self.loaded_map[domain_id]
        result = self.doLoad(domain_id, rs)
        self.loaded_map[domain_id] = result
        return result

    def doLoad(self, domain_id, rs):
        pass

