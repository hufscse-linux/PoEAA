import sqlite3
def setting(domain_name, domain_id, primary_key):
    statement = "SELECT * FROM %s where %s = ? "%(domain_name, primary_key)
    try:
        conn = sqlite3.connect('../dry.sqlite3')
        conn.row_factory = sqlite3.Row
        cursor = conn.cursor()
        cursor.execute(statement, (domain_id,))
        rs = cursor.fetchone()
        def f(cls):
            for key in rs.keys():
                setattr(cls, key, rs[key])
            return cls
        return f
    except Exception as e:
        print e

def get_cls(cls, domain_name, domain_id, primary_key):
    @setting(domain_name, domain_id, primary_key)
    class domain(cls):
        pass

    return domain()
