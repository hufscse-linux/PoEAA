class Position(object):
    def __init__(self, position_id, title):
        self.position_id = position_id
        self.title = title

    def __repr__(self):
        return "<Position(title= %s) >" %(self.title)

