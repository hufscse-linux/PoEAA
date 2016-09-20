import sqlite3

def setting(domain_name, domain_id, primary_key):
    statement = "SELECT %s FROM %s where %s = ? "%(primary_key, domain_name, primary_key)
    try:
        conn = sqlite3.connect('../dry.sqlite3')
        cursor = conn.cursor()
        cursor.execute(statement, (domain_id,))
        rs = cursor.fetchone()
        def f(cls):
            setattr(cls, primary_key, rs[0])
            return cls
        return f
    except Exception as e:
        print e

class Position(object):
    def __repr__(self):
        return "<Position(title= %s) >" %(self.title)



def get_cls(cls, domain_name, domain_id, primary_key):
    @setting(domain_name, domain_id, primary_key)
    class domain(cls):
        pass

    return domain()


if __name__ == "__main__":
    t = get_cls(Position, "Position", 1, "PositionId")
    print t.PositionId
