import sqlite3
def setting(domain_name, domain_id, primary_key, keys):
    columns = ', '.join(key for key in keys)
    statement = "SELECT %s FROM %s where %s = ? "%(columns, domain_name, primary_key)
    try:
        conn = sqlite3.connect('../dry.sqlite3')
        cursor = conn.cursor()
        cursor.execute(statement, (domain_id,))
        rs = cursor.fetchone()
        key_value = zip(keys, rs)
        def f(cls):
            for key, value in key_value:
                setattr(cls, key, value)
            return cls
        return f
    except Exception as e:
        print e

def get_cls(cls, domain_name, domain_id, primary_key, keys):
    @setting(domain_name, domain_id, primary_key, keys)
    class domain(cls):
        pass

    return domain()
